package model.mapper;
import model.TalentTest;

public interface TalentTestMapper {
	TalentTest getTalentTestByUserId(int userId);
	public int insertTalentTest(TalentTest t);   
	public int updateTalentTest(TalentTest t);
	public int deleteTalentTest(int userId);   
}
