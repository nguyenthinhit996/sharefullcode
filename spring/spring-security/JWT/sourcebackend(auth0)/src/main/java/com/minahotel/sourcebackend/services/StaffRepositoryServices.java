package com.minahotel.sourcebackend.services;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.minahotel.sourcebackend.enums.EnumTicketAndRoom;
import com.minahotel.sourcebackend.enums.EnumTypeServices;
import com.minahotel.sourcebackend.pojo.ChangePassPojo;
import com.minahotel.sourcebackend.pojo.LoginPojo;
import com.minahotel.sourcebackend.pojo.MinaHoTelPojo;
import com.minahotel.sourcebackend.pojo.Staff;
import com.minahotel.sourcebackend.repository.StaffRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class StaffRepositoryServices implements MinaHotelServices, UserDetailsService {

	// Spring Boot will create and configure DataSource and JdbcTemplate
	// To use it, just @Autowired
	@Autowired
	private StaffRepository staffRepository;

	public StaffRepositoryServices() {
		super();
	}

	public boolean createObject(MinaHoTelPojo staff) {
		try {
			List<Staff> ds = (List<Staff>) staffRepository.findAll();
			int max = 0;
			for (Staff in : ds) {
				String str = in.getIdstaff();
				int index = Integer.valueOf(str.split("_")[1]);
				if (index > max) {
					max = index;
				}
			}
			max+=1;
			String idStaff = "staff_" + max;
			Staff staffConvertFromMina = (Staff) staff;
			staffConvertFromMina.setPass("123"); // set default
			staffConvertFromMina.setIdstaff(idStaff);
			staffConvertFromMina.setStatus(EnumTicketAndRoom.ON.getName());
			staffConvertFromMina.setPass(bCryptPasswordEncoder().encode(staffConvertFromMina.getPass()));
			staffRepository.save(staffConvertFromMina);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean saveOrUpdate(MinaHoTelPojo staff) {
		Staff staffConvertFromMina = (Staff) staff;
		Staff result = staffRepository.findStaffByIdOnlyOne(staffConvertFromMina.getIdstaff()).map(x -> {
			x.setBonussalary(staffConvertFromMina.getBonussalary());
			x.setDatework(staffConvertFromMina.getDatework());
			x.setRole(staffConvertFromMina.getRole());
			x.setSalarymonth(staffConvertFromMina.getSalarymonth());
			x.setUsername(staffConvertFromMina.getUsername());
			x.setStatus(staffConvertFromMina.getStatus());
			return staffRepository.save(x);
		}).orElseGet(() -> {
			createObject(staff);
			return (Staff) staff;
		});
		return result != null ? true : false;
	}

	public boolean resetPassword(String idstaff) {
		Optional<Staff> result = staffRepository.findStaffByIdOnlyOne(idstaff);
		Staff staffSuccess = null;
		if(result.isPresent()) {
			Staff staff = result.get();
			staff.setPass(bCryptPasswordEncoder().encode("123"));
			staffSuccess = staffRepository.save(staff);
		}
		return staffSuccess != null ? true : false;
	}

	
	public void deleteObject(MinaHoTelPojo staff) {
		Staff staffConvertFromMina = (Staff) staff;
		staffRepository.delete(staffConvertFromMina);
	}

	@Override
	public List<? extends MinaHoTelPojo> getAll() {
		return (List<Staff>) staffRepository.findAll();
	}

	@Override
	public List<? extends MinaHoTelPojo> getObjectById(String... id) {
		return staffRepository.findStaffById(id[0]);
	}

//	RowMapper<Staff> rowMappStaff = new RowMapper<>() {
//		public Staff mapRow(ResultSet set, int rowNum) throws SQLException {
//			Staff cus = new Staff();
//			cus.setIdstaff(set.getString(EnumStaff.IDSTAFF.getName()));
//			cus.setUsername(set.getString( EnumStaff.USERNAME.getName()));
//			cus.setPass(set.getString(EnumStaff.PASS.getName()));
//			cus.setRole(set.getString(EnumStaff.ROLE.getName()));
//			cus.setDatework(set.getDate(EnumStaff.DATEWORK.getName()).toLocalDate());
//			cus.setSalarymonth(set.getBigDecimal(EnumStaff.SALARYMONTH.getName()));
//			cus.setBonussalary(set.getBigDecimal(EnumStaff.BONUSSALARY.getName()));
//			return cus;
//		}
//	};

	public Boolean checkLogin(LoginPojo loginPojo) {
		Optional<Staff> staff = staffRepository.findStaffByIdOnlyOne(loginPojo.getUsername());
		if (staff.isPresent() && EnumTicketAndRoom.ON.getName().equals(staff.get().getStatus())) {
			boolean status = bCryptPasswordEncoder().matches(loginPojo.getPassword(), staff.get().getPass());
			if (status) {
				loginPojo.setRole(staff.get().getRole());
				loginPojo.setFullName(staff.get().getUsername());
				loginPojo.setAuthenticated(true);
				return true;
			}
		}
		return false;
	}

	public String changePass(ChangePassPojo object) {
		Optional<Staff> staff = staffRepository.findStaffByIdOnlyOne(object.getIdStaff());
		if (staff.isPresent()) {
			boolean status = bCryptPasswordEncoder().matches(object.getPasswordOld(), staff.get().getPass());
			if (status) {
				staff.get().setPass(bCryptPasswordEncoder().encode(object.getPasswordNew()));
				saveOrUpdate(staff.get());
				return "Update Password Success";
			} else {
				return "Password old incorrect";
			}
		} else {
			return "User not found";
		}
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Staff> staff = staffRepository.findStaffByNameID(username);
		if (staff.isPresent()) {
			UserDetails userDetails = new UserDetails() {

				/**
				* 
				*/
				private static final long serialVersionUID = 1000L;

				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public boolean isCredentialsNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public boolean isAccountNonLocked() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public boolean isAccountNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public String getUsername() {
					// TODO Auto-generated method stub
					return staff.get().getUsername();
				}

				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return staff.get().getPass();
				}

				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					GrantedAuthority grantedAuthority = new GrantedAuthority() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override
						public String getAuthority() {
							// TODO Auto-generated method stub
							return staff.get().getRole();
						}
					};

					return List.of(grantedAuthority);
				}
			};
			return userDetails;
		} else {
			return null;
		}

	}

	
	void autotime() {
		
	}
}
