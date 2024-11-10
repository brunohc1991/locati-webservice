package com.locati.webservice.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Installment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INSTALLMENT")
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dueDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date paymentDate;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "ID_ORDER")
	private Payment payment;
	
	public Installment() {}

	public Installment(Long id, Date dueDate, Date paymentDate, Payment payment) {
		super();
		this.id = id;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Installment other = (Installment) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
