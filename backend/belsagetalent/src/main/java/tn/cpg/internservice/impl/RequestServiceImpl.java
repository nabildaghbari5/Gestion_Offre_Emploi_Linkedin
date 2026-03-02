package tn.cpg.internservice.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import tn.cpg.internservice.dto.RequestDto;
import tn.cpg.internservice.exception.NotFoundException;
import tn.cpg.internservice.mapper.RequestMapper;
import tn.cpg.internservice.model.Request;
import tn.cpg.internservice.model.Announcement;
import tn.cpg.internservice.repository.AnnouncementRepository;
import tn.cpg.internservice.repository.RequestRespository;
import tn.cpg.internservice.service.RequestService;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
	
	private final RequestRespository RequestRespository ; 
	private final RequestMapper requestMapper ;
	private final AnnouncementRepository announcementRepository ;

	
	
	@Override
	public RequestDto create(RequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public RequestDto creats(RequestDto dto, Integer announcementId) {
		Request entity = requestMapper.toENTITY(dto);
		Announcement announcement =announcementRepository.findById(announcementId)
				.orElseThrow(() -> new RuntimeException("announcement non trouvé avec l'ID : " + announcementId));
		entity.setAnnouncement(announcement);
		entity.setDateCreation(LocalDate.now());
		return requestMapper.toDTO(RequestRespository.save(entity));
	}
	
	@Override
	public RequestDto update(Integer id, RequestDto dto) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RequestDto findById(Integer id) throws NotFoundException {
		Request entity = RequestRespository.findById(id)
				.orElseThrow(() -> new RuntimeException("demande not found"));
		return requestMapper.toDTO(entity);
	}
	@Override
	public List<RequestDto> findAll() {
		return RequestRespository.findAll()
				.stream()
				.map(requestMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public void delete(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<RequestDto> findByCandidatId(String candidatId) {
		return  RequestRespository.findRequestsByCandidateId(candidatId)
				.stream()
				.map(requestMapper::toDTO)
				.collect(Collectors.toList());
	}


	@Override
	public RequestDto updateStatus(Integer demandeId, String status) {
		Request request = RequestRespository.findById(demandeId)
				.orElseThrow(() -> new RuntimeException("demande not found"));
		request.setStatus(status);
		
		return requestMapper.toDTO(
				RequestRespository.save(request)
				);
	}


	@Override
	public List<RequestDto> findByStatus() {
		
		return RequestRespository.findByStatus("Accepter")
				.stream()
				.map(requestMapper::toDTO)
				.collect(Collectors.toList()); 
	}



}
