package tn.cpg.internservice.mapper;

import org.mapstruct.Mapper;

import tn.cpg.internservice.dto.RequestDto;
import tn.cpg.internservice.model.Request;

@Mapper() 
public interface RequestMapper  extends BaseMapper<RequestDto, Request>{

}
