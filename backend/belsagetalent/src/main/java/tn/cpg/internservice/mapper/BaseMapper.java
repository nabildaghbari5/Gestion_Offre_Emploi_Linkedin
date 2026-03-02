package tn.cpg.internservice.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface  BaseMapper<DTO , ENTITY>  {
	
	ENTITY toENTITY(DTO dto);
	@BeanMapping(ignoreByDefault = false)
	DTO toDTO(ENTITY entity);
	
	@Named("partialUpdate")
	@BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
	void partialUpdate(@MappingTarget ENTITY entity , DTO dto);

}
