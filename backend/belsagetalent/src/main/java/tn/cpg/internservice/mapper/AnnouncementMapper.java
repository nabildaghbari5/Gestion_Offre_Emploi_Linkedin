



package tn.cpg.internservice.mapper;

import org.mapstruct.Mapper;

import tn.cpg.internservice.dto.AnnouncementDto;
import tn.cpg.internservice.model.Announcement;

@Mapper()
public interface AnnouncementMapper extends BaseMapper<AnnouncementDto, Announcement>{
	
	
}
