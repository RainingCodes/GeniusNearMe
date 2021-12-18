package model.mapper;
import model.Group;

public interface GroupMapper {
	Group getGroupByTalentId(int talentId);
}
