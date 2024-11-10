package com.locati.webservice.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.locati.webservice.domain.enums.PaymentState;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private Integer paymentState;
	
	@OneToOne
	@JoinColumn(name = "ID_ORDER")
	@MapsId
	@JsonBackReference
	private Order order;
	
	@OneToMany(mappedBy = "payment")
	@JsonManagedReference
	private List<Installment> installments = new ArrayList<>();
	
	public Payment() {}

	public Payment(Long id, PaymentState paymentState, Order order) {
		super();
		this.id = id;
		this.paymentState = paymentState.getCod();
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentState getPaymentState() {
		return PaymentState.fromCode(paymentState);
	}

	public void setPaymentState(PaymentState paymentState) {
		this.paymentState = paymentState.getCod();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
