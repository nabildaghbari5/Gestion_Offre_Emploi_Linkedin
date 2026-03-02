package com.wingbels.belssagecore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wingbels.belssagecore.entities.Bcdocuments;
import com.wingbels.belssagecore.entities.Bcemployees;

@Service
public interface Bcdocumentsservice {
	
	public Bcdocuments save(Bcdocuments document);
	public void delete(Long idbcdocument);
	public int createDocument(MultipartFile file, Long idemployee);
    public int updateDocument(MultipartFile file, Long idemployee);
    public Optional<Bcdocuments> finddocumentbyid(Long idbcdocument);
    public List<Bcdocuments> findall();
    public List<Bcdocuments> finddocumentsbyEmp(Bcemployees Emp);
}
