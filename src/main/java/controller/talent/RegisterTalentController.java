package controller.talent;

import java.io.File;
import java.util.List;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.ExistingTalentException;
import service.ExistingUserException;
import service.MemberService;
import service.MemberServiceImpl;
import service.PriceService;
import service.PriceServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.PriceDTO;
import service.dto.TalentDTO;

//파일 업로드를 위한 API를 사용하기 위해...
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;

//파일 용량 초과에 대한 Exception 클래스를 FileUploadBase 클래스의 Inner 클래스로 처리
import org.apache.commons.fileupload.servlet.*;

public class RegisterTalentController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(RegisterTalentController.class);

	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	long miliseconds = System.currentTimeMillis();
    Date current = new Date(miliseconds);
    String src = null;
     
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";	
        }
		HttpSession session = request.getSession();
		String email = UserSessionUtils.getLoginUserId(session);
		MemberService mem = new MemberServiceImpl();
		int userId = mem.getuserIdByEmail(email);
		
		String filename = null;
		Date start = null;
		Date deadline = null;
		String title = null;
		String content = null;
		String category = null;
		int postType = -1;
		int price = -1;
		int student = -1;
		int num[] =new int[10];
		int prices[] = new int[10];
		int k = 1;
		
		
		boolean check = ServletFileUpload.isMultipartContent(request);
		//전송된 데이터의 인코드 타입이 multipart 인지 여부를 체크한다.
		//만약 multipart가 아니라면 파일 전송을 처리하지 않는다.
		
		if(check) {//파일 전송이 포함된 상태가 맞다면
			
			// 아래와 같이 하면 Tomcat 내부에 복사된 프로젝트의 폴더 밑에 upload 폴더가 생성됨 
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/upload");
			File dir = new File(path);
			
			// Tomcat 외부의 폴더에 저장하려면 아래와 같이 절대 경로로 폴더 이름을 지정함
//			 File dir = new File("C:/Temp");
			
			if(!dir.exists()) dir.mkdir();
			//전송된 파일을 저장할 실제 경로를 만든다.
			
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
                //파일 전송에 대한 기본적인 설정 Factory 클래스를 생성한다.
                factory.setSizeThreshold(10 * 1024);
                //메모리에 한번에 저장할 데이터의 크기를 설정한다.
                //10kb 씩 메모리에 데이터를 읽어 들인다.
                factory.setRepository(dir);
                //전송된 데이터의 내용을 저장할 임시 폴더를 지정한다.                
    
                ServletFileUpload upload = new ServletFileUpload(factory);
                //Factory 클래스를 통해 실제 업로드 되는 내용을 처리할 객체를 선언한다.
                upload.setSizeMax(10 * 1024 * 1024);
                //업로드 될 파일의 최대 용량을 10MB까지 전송 허용한다.
                upload.setHeaderEncoding("utf-8");
                //업로드 되는 내용의 인코딩을 설정한다.
                                
                List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
                
                //upload 객체에 전송되어 온 모든 데이터를 Collection 객체에 담는다.
                for(int i = 0; i < items.size(); ++i) {
                	FileItem item = (FileItem)items.get(i);
                	//commons-fileupload를 사용하여 전송받으면 
                	//모든 parameter는 FileItem 클래스에 하나씩 저장된다.
                	
                	String value = item.getString("utf-8");
                	//넘어온 값에 대한 한글 처리를 한다.
                	
                	if(item.isFormField()) {//일반 폼 데이터라면...                		
                		if(item.getFieldName().equals("startDate")) {
                			start = format1.parse(value);
                		}
                	
                		else if(item.getFieldName().equals("deadline")) {
                			deadline = format1.parse(value);
                		}
                		else if(item.getFieldName().equals("title")) {
                			title = value;
                		}
                		else if(item.getFieldName().equals("content")) {
                			content = value;
                		}
                		else if(item.getFieldName().equals("category")) {
                			category = value;
                		}
                		else if(item.getFieldName().equals("postType")) {
                			postType = Integer.parseInt(value);
                		}
                	
                		else if(item.getFieldName().equals("price")) {
                			price = Integer.parseInt(value);
                		}
                		else if(item.getFieldName().equals("student")) {
                			student = Integer.parseInt(value);
                		}
                		else if(item.getFieldName().equals("num"+k)) {
                			num[k] = Integer.parseInt(value);
                		}
                		else if(item.getFieldName().equals("price"+k)) {
                			prices[k] = Integer.parseInt(value);
                			k++;
                		}
                		
                	}
                	else {//파일이라면...
                		if(item.getFieldName().equals("picture")) {
                		//key 값이 picture이면 파일 저장을 한다.
                			filename = item.getName();//파일 이름 획득 (자동 한글 처리 됨)
                			if(filename == null || filename.trim().length() == 0) continue;
                			//파일이 전송되어 오지 않았다면 건너 뛴다.
                			filename = filename.substring(filename.lastIndexOf("\\") + 1);
                			//파일 이름이 파일의 전체 경로까지 포함하기 때문에 이름 부분만 추출해야 한다.
                			//실제 C:\Web_Java\aaa.gif라고 하면 aaa.gif만 추출하기 위한 코드이다.
                			File file = new File(dir, filename);
                			item.write(file);
                			//파일을 upload 경로에 실제로 저장한다.
                			//FileItem 객체를 통해 바로 출력 저장할 수 있다.
                		}
                	}
                }
			}catch(SizeLimitExceededException e) {
				//업로드 되는 파일의 크기가 지정된 최대 크기를 초과할 때 발생하는 예외처리
					e.printStackTrace();           
	        }catch(FileUploadException e) {
	            //파일 업로드와 관련되어 발생할 수 있는 예외 처리
	                e.printStackTrace();
	        }catch(Exception e) {            
	                e.printStackTrace();
	        }
			
			TalentDTO dto = new TalentDTO(
					title,
					content,
					start,
					deadline,
					current,
					0,
					userId,
					category,
					postType);//0=selling, 1=demanding
			System.out.println(dto);
			
			log.debug("Create Talent : {}", dto.getTitle());
			
			System.out.println("재능 추가");
			TalentService talentService = new TalentServiceImpl();
			System.out.println("here");
			int talentId = talentService.insertTalent(dto);
			System.out.println(talentId+ "완료");
			
			PriceService priceService = new PriceServiceImpl();
			PriceDTO dto1 = new PriceDTO(talentId, 1, price);
			int result = priceService.insertPrice(dto1);
			
			System.out.println(result);
			System.out.println("student값: "+student);
			ArrayList<PriceDTO> priceList = new ArrayList<>();
			for(int i = 1; i <= student; i++) {
				PriceDTO dto2 = new PriceDTO(
						talentId,
						num[i],
						prices[i]
						);
				result = priceService.insertPrice(dto2);
				priceList.add(dto2);
				System.out.println(result);
			}
			
			request.setAttribute("dir", dir);
			request.setAttribute("filename", filename);
			request.setAttribute("talentId", talentId);
			request.setAttribute("priceList", priceList);
			src = "/talent/view?talentId=" +talentId; 
			System.out.println(src);
			
		}
           return src;
	}
}
