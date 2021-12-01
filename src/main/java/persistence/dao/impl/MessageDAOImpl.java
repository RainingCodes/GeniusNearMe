package persistence.dao.impl;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import persistence.dao.MessageDAO;
import persistence.util.JDBCUtil;
import service.dto.MessageDTO;

public class MessageDAOImpl implements MessageDAO {
	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT MESSAGEID, STATE, CONTENT, WRITTENDATE, SENDERID, RECEIVERID ";

	public MessageDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	//1.senderId로 메세지 목록 가져오기
	public List<MessageDTO> getMessageListBySenderId(int senderId) {
		String searchQuery = query + "FROM MESSAGE "+"WHERE SENDERID = ? ";

		Object[] param = new Object[] { senderId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MessageDTO> list = new ArrayList<MessageDTO>();
			
			while (rs.next()) {
				MessageDTO dto = new MessageDTO();
				dto.setMessageId(rs.getInt("MESSAGEID"));
				dto.setState(rs.getInt("STATE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));;
				dto.setSenderId(rs.getInt("SENDERID"));
				dto.setReceiverId(rs.getInt("RECEIVERID"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
		
	//2.receiverId로 메세지 목록 가져오기
	public List<MessageDTO> getMessageListByReceiverId(int receiverId) {
		String searchQuery = query + "FROM MESSAGE "+"WHERE RECEIVERID = ? ";

		Object[] param = new Object[] { receiverId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MessageDTO> list = new ArrayList<MessageDTO>();
			
			while (rs.next()) {
				MessageDTO dto = new MessageDTO();
				dto.setMessageId(rs.getInt("MESSAGEID"));
				dto.setState(rs.getInt("STATE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));;
				dto.setSenderId(rs.getInt("SENDERID"));
				dto.setReceiverId(rs.getInt("RECEIVERID"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
		
	//3.messageId로 메세지 하나 가져오기
	public MessageDTO getMessageById(int messageId) {
		String searchQuery = query + "FROM MESSAGE "+"WHERE MESSAGEID = ? ";

		Object[] param = new Object[] { messageId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MessageDTO dto = new MessageDTO();
			
			if (rs.next()) {
				dto.setMessageId(rs.getInt("MESSAGEID"));
				dto.setState(rs.getInt("STATE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));;
				dto.setSenderId(rs.getInt("SENDERID"));
				dto.setReceiverId(rs.getInt("RECEIVERID"));
				
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
		
		
	//4.메세지 insert하기(insert에선 state 무조건 0임)
	public int InsertMessage(MessageDTO message) {
		int result = 0;
		String insertQuery = "INSERT INTO MESSAGE (MESSAGEID, STATE, CONTENT, WRITTENDATE, SENDERID, RECEIVERID) "
							+ "VALUES (message_seq.nextval, 0, ?, ?, ?, ?) ";
		System.out.println(insertQuery);
		System.out.println(new java.sql.Date(message.getWrittenDate().getTime()));
		
		Object[] param = new Object[] { message.getContent(), new java.sql.Date(message.getWrittenDate().getTime()), message.getSenderId(), message.getReceiverId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
		
	//5.메세지 state read로 update하기(insert에선 무조건 0임)
	public int updateMessageStateToRead(int messageId) {
		int result = 0;

		String updateQuery = "UPDATE MESSAGE SET STATE = ? WHERE MESSAGEID = ? ";
		
		System.out.println(updateQuery);
		Object[] newParam = {1, messageId};

		jdbcUtil.setSqlAndParameters(updateQuery, newParam);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
		
	//6.메세지 delete하기
	public int DeleteMessage(int messageId) {
		int result = 0;
		String DeleteQuery = "DELETE FROM MESSAGE WHERE MESSAGEID = ? ";
		
		Object[] param = new Object[] {messageId};
		jdbcUtil.setSqlAndParameters(DeleteQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}
		
	//7.메세지 id로 state감별
	public int stateByMessageId(int messageId) { 
		String searchQuery = "SELECT STATE FROM MESSAGE "+"WHERE MESSAGEID = ? ";

		Object[] param = new Object[] { messageId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		int result = -1;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("STATE");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return result;
	}
}
