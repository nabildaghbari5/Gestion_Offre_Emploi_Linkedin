package com.wingbels.belssagecore.servicesImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wingbels.belssagecore.entities.Bcdocuments;
import com.wingbels.belssagecore.entities.Bcemployees;
import com.wingbels.belssagecore.repositories.Bcdocumentsrepository;
import com.wingbels.belssagecore.services.Bcdocumentsservice;
import com.wingbels.belssagecore.services.Bcemployeesservice;

@Service
public class Bcdocumentsseviceimp implements Bcdocumentsservice {
	@Autowired
	Bcdocumentsrepository bcdocumentsrepository;
	Bcemployeesservice bcemployeesservice;

	@Override
	public Bcdocuments save(Bcdocuments document) {
		return bcdocumentsrepository.save(document);
	}

	@Override
	public void delete(Long idbcdocument) {
		bcdocumentsrepository.deleteById(idbcdocument);
	}

	@Override
	public int createDocument(MultipartFile file, Long idemployee) {
		Bcemployees employee = bcemployeesservice.findbyid(idemployee).get();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		int index = fileName.lastIndexOf(".");
		String fileType = fileName.substring(index + 1);

		Bcdocuments document = new Bcdocuments();
		document.setFileName(fileName);
		document.setFileType(fileType);
		document.setEmployee(employee);
		return save(document) != null ? 1 : 2;
	}

	@Override
	public int updateDocument(MultipartFile file, Long idemployee) {
		return createDocument( file, idemployee);
	}

	@Override
	public Optional<Bcdocuments> finddocumentbyid(Long idbcdocument) {
		return bcdocumentsrepository.findByIddocument(idbcdocument);
	}

	@Override
	public List<Bcdocuments> findall() {
		return bcdocumentsrepository.findAll();
	}

	@Override
	public List<Bcdocuments> finddocumentsbyEmp(Bcemployees Emp) {
		return bcdocumentsrepository.findByEmployee(Emp);
	}

}
