package com.happytrip.petcargo.controller;

import java.io.FileNotFoundException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytrip.petcargo.dao.UserDao;
import com.happytrip.petcargo.model.AdmitCard;
import com.happytrip.petcargo.model.Bin;
import com.happytrip.petcargo.model.Payment;
import com.happytrip.petcargo.model.Pet;
import com.happytrip.petcargo.model.PetBooking;
import com.happytrip.petcargo.model.User;
import com.happytrip.petcargo.service.AdmitCardService;
import com.happytrip.petcargo.service.PaymentService;
import com.happytrip.petcargo.service.PetBookingService;
import com.happytrip.petcargo.service.PetService;
import com.happytrip.petcargo.service.impl.BarCode128;
import com.lowagie.text.DocumentException;

@Controller
public class PetController {

	@Autowired
	PetService petService;
	@Autowired
	HttpSession session;
	@Autowired
	UserDao userDao;
	@Autowired
	PetBookingService petBookingService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	AdmitCardService admitCardService;
	
	@ModelAttribute("pet1")
	public Pet getPet(){
		return new Pet();
   }
	@ModelAttribute("payment")
	public Payment getPayment(){
		return new Payment();
   }
		
	@RequestMapping("/pay")
	public String listBins(Map<String, Object> map,Model model) {
			//map.put("pet1", new Pet());
			
			return "showSearch1/pay";
	}
	@RequestMapping(value = "showSearch/bookBin/pay{user}",method = RequestMethod.POST)
	public String addPet(@RequestParam("user") String userId,@ModelAttribute("pet1")Pet pet1,BindingResult result) 
	{
		int id=Integer.parseInt(userId);
		User user1=new User();
		user1=userDao.fetchUser(id);
		pet1.setUser(user1);
		petService.savePet(pet1);
		Bin bin=(Bin) session.getAttribute("binPrice");
		petBookingService.saveBooking(id, petService.fetchPetByUserId(user1.getUserId()),bin.getBinId());
		session.setAttribute("petbooking", petBookingService.fetchByPetId(petService.fetchPetByUserId(user1.getUserId())));
		return "pay";
	}
	@RequestMapping(value = "showSearch/bookBin/paymentDone",method = RequestMethod.POST)
	public String addPayment(@ModelAttribute("payment")Payment payment ,BindingResult result) 
	{
		PetBooking petBooking=new PetBooking();
		petBooking=(PetBooking) session.getAttribute("petbooking");
		User user=new User();
		user=petBooking.getUser();
		payment.setPetBooking(petBooking);
		payment.setUser(user);
		paymentService.makePayment(payment);
		String deatils="Booking Id   :"+petBooking.getBookingId()+"\n User Reference Number   :"+user.getUserId()+"\n Payment Id   :"+paymentService.fetchByBookingId(petBooking.getBookingId()).getPaymentId();
	    long barCode=	BarCode128.generateBarcodeNum();
	    try {
			BarCode128.generateBarcode(barCode, deatils);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    AdmitCard admitCard=new AdmitCard();
	    admitCard.setBarcodeNo(barCode);
	    admitCard.setBooking(petBooking);
	    admitCard.setUser(user);
	    admitCardService.createAdmitCard(admitCard);
		return "admitCard";
	}}
