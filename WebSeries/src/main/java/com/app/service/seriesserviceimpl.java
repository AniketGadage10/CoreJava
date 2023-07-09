package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.apiresponsedto;
import com.app.dto.seriesreqDTO;
import com.app.dto.updateDTO;
import com.app.entities.Catagory;
import com.app.entities.series;
import com.app.excpetion.CustomException;
import com.app.repository.Seriesrepo;

@Service
@Transactional
public class seriesserviceimpl implements seriesservice {

	@Autowired
	private Seriesrepo srepo;

	@Autowired
	private ModelMapper mp;

	public seriesreqDTO insert(seriesreqDTO sdto) {
		series s = mp.map(sdto, series.class);
		series s1 = srepo.save(s);
		return mp.map(s1, seriesreqDTO.class);
	}

	public List<series> get(String sname) {
		return srepo.findByCname(Catagory.valueOf(sname));
	}

	public seriesreqDTO put(updateDTO udto) {
		series s = srepo.findById(udto.getSid()).orElseThrow(() -> new CustomException("Series Not Found"));
		s.setModifydate(udto.getModifydate());
		series s1 = srepo.save(s);
		return mp.map(s1, seriesreqDTO.class);
	}

	public apiresponsedto delete(Long sid) {
		if (srepo.existsById(sid)) {
			srepo.deleteById(sid);
			return new apiresponsedto("Series Deletion Sucessfully ");
		}
		return new apiresponsedto("Series Deletion Fail ");
	}
}
