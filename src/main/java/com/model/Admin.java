package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {

	//admin fields
	
		@Id
		@GeneratedValue
		@Column(name="admin_id")
		private int adminId;
		@NotNull
		@Column(name="admin_username")
		private String adminUsername;
		@NotNull
		@Size(min=8,message="password should have atleast 8 characters")
		@Column(name="admin_password")
		private String adminPassword;
		
		//getters and setters
		
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getAdminUsername() {
			return adminUsername;
		}
		public void setAdminUsername(String adminUsername) {
			this.adminUsername = adminUsername;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		
		//to string
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
					+ "]";
		}

}
