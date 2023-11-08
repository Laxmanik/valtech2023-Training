package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //joined table

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //single table example
//@DiscriminatorColumn(name = "disc")   //Class level annotation
//@DiscriminatorValue("tx")
//@Table(name = "alltxs")

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@NamedQueries({
	@NamedQuery(name = "Tx.findAll", query = "SELECT tx from Tx tx"),
	@NamedQuery(name = "Tx.findAllByCityAndAmountGreaterThan", query = "SELECT tx from Tx tx join tx.account.customers c WHERE c.address.city = ? AND tx.amount > ?")
})
public class Tx { //Transaction Class

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
//	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "abc")
//	@TableGenerator(name = "abc", table = "pktable", pkColumnName = "PkCol", pkColumnValue = "txSeq", valueColumnName = "seed", allocationSize = 50)
	private int id;
	private float amount;
	@ManyToOne(targetEntity = Account.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	
	
	public Tx() {}
	
	public Tx(float amount) {
		this.amount = amount;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
