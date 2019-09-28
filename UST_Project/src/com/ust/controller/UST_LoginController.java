package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.Contact_Details;
import com.ust.beans.UST_Login;
import com.ust.beans.VendorNContact;
import com.ust.beans.Vendor_Details;
import com.ust.dao.Contact_DetailsDao;
import com.ust.dao.UST_LoginDao;
import com.ust.dao.Vendor_DetailsDao;

@RestController
public class UST_LoginController {
	
	@Autowired
	UST_LoginDao ustloginDao;
	
	@Autowired
	Vendor_DetailsDao vendorDao;
	
	@Autowired
	Contact_DetailsDao contactDao;
	
	//validation
	@ResponseBody
	@RequestMapping(value="login/{username}/{password}",method=RequestMethod.GET)

	public UST_Login login(@PathVariable("username")String uid,@PathVariable("password")String pw){
		return ustloginDao.findAll(uid,pw);
	}

	 //list of vendors
	 @ResponseBody
	 @RequestMapping(value="login/listofvendor",method=RequestMethod.GET)
	 public List<Vendor_Details> list(){
		 List<Vendor_Details> vendors=vendorDao.findAll();
		 return vendors;
	 }
	 
	 //inserting into vendor details..
	 @ResponseBody
	 @RequestMapping(value="login/insertvendor",method={RequestMethod.POST,RequestMethod.GET})
	 public void insertVendor (@RequestBody Vendor_Details vendorDetails){
		 vendorDao.insertVendor(vendorDetails);
		 
	 }
	 
	 //searching vendor by vendorid
	 @ResponseBody
	 @RequestMapping(value="login/vendordetails/{vid}",method=RequestMethod.GET)
	 public Vendor_Details getByVendorId(@PathVariable("vid")int vid){
		 return vendorDao.getById(vid);
	 }
	 
	//updating vendor details
	 @ResponseBody
	 @RequestMapping(value="login/updatevendor",method={RequestMethod.PUT,RequestMethod.GET})
	 public void updateVendor(@RequestBody Vendor_Details vendor){
		vendorDao.updateVendor(vendor);
	 }
	 
	 //disabling vendor details
	 @ResponseBody
	 @RequestMapping(value="login/disablevendor/{vid}",method={RequestMethod.PUT,RequestMethod.GET})
	 public void disableVendor(@PathVariable("vid") int id){
		 vendorDao.disableVendor(id);
	 }
	 
	 
	 
	//list of contacts
		 @ResponseBody
		 @RequestMapping(value="login/listofcontact/{vid}",method=RequestMethod.GET)
		 public List<Contact_Details> listOfContact(@PathVariable("vid")int vId){
			 List<Contact_Details> contacts=contactDao.findAll(vId);
			 return contacts;
		 }
		 
	//inserting into contact details..
		 @ResponseBody
		 @RequestMapping(value="login/insertcontact",method={RequestMethod.POST,RequestMethod.GET})
		 public void insertContact (@RequestBody Contact_Details contactDetails){
			 contactDao.insertContact(contactDetails);
			 
		 }
		 
		 //searching vendor by contactid
		 @ResponseBody
		 @RequestMapping(value="login/contactdetails/{cid}",method=RequestMethod.GET)
		 public Contact_Details getByContactId(@PathVariable("cid")int cId){
			 return contactDao.getById(cId);
		 }
		 
		//updating contact details
		 @ResponseBody
		 @RequestMapping(value="login/updatecontact",method={RequestMethod.PUT,RequestMethod.GET})
		 public void updateContact(@RequestBody Contact_Details contact){
			contactDao.updateContact(contact);
		 }
		 
		 //disabling contact details
		 @ResponseBody
		 @RequestMapping(value="login/disablecontact/{cid}",method={RequestMethod.PUT,RequestMethod.GET})
		 public void disableContact(@PathVariable("cid") int id){
			 contactDao.disableContact(id);
		 }
		 
		 //inserting into vendor and contact
		 
		 @RequestMapping(value="login/vendorcontact",method={RequestMethod.POST,RequestMethod.GET})
		 public void insertVendorNContact(@RequestBody VendorNContact vendorcon){
			 vendorDao.insertContactVendor(vendorcon);
		 }
		 
		 //updating vendor and contact
		 
		 @RequestMapping(value="login/vendorcontactedit",method={RequestMethod.PUT,RequestMethod.GET})
		 public void updateVendorNContact(@RequestBody VendorNContact vc) throws ParseException {
				int vendor_id = vc.getVendorId();
				vendorDao.updateVendorNContact(vendor_id, vc);
			}
		 
		 //displaying vendor details by id
		 @RequestMapping(value="/login/vendorcontactEditAll/{vid}",method=RequestMethod.GET)
		 public VendorNContact getVendorNContact(@PathVariable("vid") int vid){
			 return vendorDao.selectAll(vid);
		 }
}
