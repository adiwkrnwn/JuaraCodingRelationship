package com.juaracoding.Controller;

import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.Repository.CustomerRepository;
import com.juaracoding.config.JwtTokenUtil;
import com.juaracoding.model.CustomerCustomeNameModel;
import com.juaracoding.model.CustomerCustomeNoHp;
import com.juaracoding.model.CustomerModel;
import com.juaracoding.service.JwtCustomerDetailService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	JwtCustomerDetailService jwtCustomerDetailService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("fullname/")
	private List<CustomerCustomeNameModel> getAllFullName(){
		return customerRepo.getAllDataFullName();
	}
	
	@GetMapping("nohp/")
	private List<CustomerCustomeNoHp> getCustomerNoHp() {
		return customerRepo.getDataCustomerNoHp();
	}
	
	@GetMapping("/idcustomer/")
	private List<CustomerModel> getIdCstomer(
			@RequestParam(name="id") long id,
			@RequestParam(name="firstname") String firstname) {
		return customerRepo.getDataById(id, firstname);
	}
	
	@PatchMapping("/updatealamat/")
	private String updatecustomer(
			@RequestParam(name="id") long id,
			@RequestParam(name="address") String address) {
		customerRepo.updateCustomer(address, id);
		return "data berhasil diubah";
	}
	
	@PatchMapping("/updateemailalamat")
	private String UpdateEmailAlamat(
			@RequestParam(name="id") long id,
			@RequestParam(name="address") String address,
			@RequestParam(name="email") String email,
			@RequestParam(name="no_hp") String no_hp) {
		customerRepo.updateEmailAlamat(address, email, id, no_hp);
		return "data berhasil diubah";
	}
	
	@PostMapping("/registrasi")
	private ResponseEntity<String> saveCustomer(
			@RequestBody CustomerModel customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerRepo.save(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Berhasil dibuat");
	}
	
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody CustomerModel customerModel) throws Exception {
		authenticate(customerModel.getUsername(),customerModel.getPassword());
		
		final UserDetails userDetails = jwtCustomerDetailService
				.loadUserByUsername(customerModel.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			// user disable
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			// invalid credentials
			throw new Exception("INVALID_CREDENTIALS", e);
		}

	}			

}
