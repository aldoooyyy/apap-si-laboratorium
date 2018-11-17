package com.apap.TAsilab.controller;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.TAsilab.model.JenisPemeriksaanModel;
import com.apap.TAsilab.model.LabSuppliesModel;
import com.apap.TAsilab.model.PemeriksaanModel;
import com.apap.TAsilab.service.JenisPemeriksaanService;
import com.apap.TAsilab.service.PemeriksaanService;


@Controller
public class PemeriksaanController {

	@Autowired
	PemeriksaanService pemeriksaanService;
	
	@Autowired
	JenisPemeriksaanService jenisPemeriksaanService;
	
	
	@RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
	public String viewAllJabatan(Model model) {
		
		List<PemeriksaanModel> listPemeriksaan = pemeriksaanService.findAll();
		
		model.addAttribute("title", "Daftar Pemeriksaan");
		model.addAttribute("listPemeriksaan", listPemeriksaan);
		return "lihat-daftar-pemeriksaan";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan", method = RequestMethod.GET)
	public String ubahStatus(@RequestParam(value= "id") Long idPemeriksaan, Model model) {
		PemeriksaanModel pemeriksaan = pemeriksaanService.findPemeriksaanById(idPemeriksaan);
		model.addAttribute("pemeriksaan", pemeriksaan);
		model.addAttribute("title", "Ubah Status");
		model.addAttribute("message", true);
		return "ubah-status";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan", method = RequestMethod.POST)
	public String ubahStatusSubmit(@ModelAttribute PemeriksaanModel statusUbah, Model model) {
		return "ubah-status";
	}
}