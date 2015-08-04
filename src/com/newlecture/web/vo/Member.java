package com.newlecture.web.vo;

import java.sql.Date;

public class Member {
	
	private String Uid;
	private String Name;
	private String Pwd;
	private String NicName;
	private String Photo;
	private String Gender;
	private String Birth;
	private boolean IsLunar;
	private String Phone;
	private String Email;
	private String ZipCode;
	private String ZipSeq;
	private String Address;
	private String DefaultRole;
	private Date RegDate;
	private String RegIP;
	
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getNicName() {
		return NicName;
	}
	public void setNicName(String nicName) {
		NicName = nicName;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public boolean isIsLunar() {
		return IsLunar;
	}
	public void setIsLunar(boolean isLunar) {
		IsLunar = isLunar;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getZipSeq() {
		return ZipSeq;
	}
	public void setZipSeq(String zipSeq) {
		ZipSeq = zipSeq;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDefaultRole() {
		return DefaultRole;
	}
	public void setDefaultRole(String defaultRole) {
		DefaultRole = defaultRole;
	}
	public Date getRegDate() {
		return RegDate;
	}
	public void setRegDate(Date regDate) {
		RegDate = regDate;
	}
	public String getRegIP() {
		return RegIP;
	}
	public void setRegIP(String regIP) {
		RegIP = regIP;
	}
	public String getRegEnv() {
		return RegEnv;
	}
	public void setRegEnv(String regEnv) {
		RegEnv = regEnv;
	}
	public String getPwdModifyKey() {
		return PwdModifyKey;
	}
	public void setPwdModifyKey(String pwdModifyKey) {
		PwdModifyKey = pwdModifyKey;
	}
	public String getRegAdmin() {
		return RegAdmin;
	}
	public void setRegAdmin(String regAdmin) {
		RegAdmin = regAdmin;
	}
	public String getGuid() {
		return Guid;
	}
	public void setGuid(String guid) {
		Guid = guid;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public String getDisabledReason() {
		return DisabledReason;
	}
	public void setDisabledReason(String disabledReason) {
		DisabledReason = disabledReason;
	}
	public String getLoginIP() {
		return LoginIP;
	}
	public void setLoginIP(String loginIP) {
		LoginIP = loginIP;
	}
	public String getLoginComputer() {
		return LoginComputer;
	}
	public void setLoginComputer(String loginComputer) {
		LoginComputer = loginComputer;
	}
	public Date getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(Date loginTime) {
		LoginTime = loginTime;
	}
	private String RegEnv;
	private String PwdModifyKey;
	private String RegAdmin;
	private String Guid;
	private boolean Enabled;
	private String DisabledReason;
	private String LoginIP;
	private String LoginComputer;
	private Date LoginTime;
	

}
