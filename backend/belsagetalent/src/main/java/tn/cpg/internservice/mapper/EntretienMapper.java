package tn.cpg.internservice.mapper;

import org.mapstruct.Mapper;
import tn.cpg.internservice.dto.EntretienDto;
import tn.cpg.internservice.model.Entretien;

@Mapper()
public interface EntretienMapper extends BaseMapper<EntretienDto , Entretien> {
}
