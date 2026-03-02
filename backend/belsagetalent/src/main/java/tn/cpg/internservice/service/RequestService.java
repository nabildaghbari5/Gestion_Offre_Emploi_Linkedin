package tn.cpg.internservice.service;

import java.util.List;

import tn.cpg.internservice.dto.RequestDto;


public interface RequestService extends BaseService<RequestDto, Integer> {

	RequestDto creats(RequestDto dto  , Integer announcementId);

	List<RequestDto> findByCandidatId(String candidatId);

	RequestDto updateStatus(Integer demandeId, String status);

	List<RequestDto> findByStatus();




}
