package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Table(name="ASSIGNED_TEL_NUM")
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryAcessAssignedTelNum",query=
					" SELECT 		R.DOCUMENT_NUMBER as documentNumber," + 
					"       		N.TEL_NBR_NPA || N.TEL_NBR_NXX || MIN (N.TEL_NBR_LINE_RANGE) as rangeInicial, " + 
					"       		N.TEL_NBR_NPA || N.TEL_NBR_NXX || MAX (N.TEL_NBR_LINE_RANGE) as rangeFinal " + 
					"FROM 		ASAP.ASSIGNED_TEL_NUM N, " + 
					"       		ASAP.SERV_REQ R " + 
					"WHERE 		R.DOCUMENT_NUMBER = N.DOCUMENT_NUMBER " + 
					"AND 		R.PON = ? " + 
					"AND 		R.TYPE_OF_SR = 'SO' " + 
					"GROUP BY 	R.DOCUMENT_NUMBER, " + 
					"       		N.TEL_NBR_NPA, " + 
					"       		N.TEL_NBR_NXX ",resultClass = RetrieveAssignedTelNumEntity.class)})

public class RetrieveAssignedTelNumEntity extends EntityCommon<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="documentNumber")
	private String documentNumber;
	
	@Column(name="rangeInicial")
	private String rangeInicial;
	
	@Column(name="rangeFinal")
	private String rangeFinal;

	/**
	 * @return the documentNumber
	 */
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the rangeInicial
	 */
	public String getRangeInicial() {
		return rangeInicial;
	}

	/**
	 * @param rangeInicial the rangeInicial to set
	 */
	public void setRangeInicial(String rangeInicial) {
		this.rangeInicial = rangeInicial;
	}

	/**
	 * @return the rangeFinal
	 */
	public String getRangeFinal() {
		return rangeFinal;
	}

	/**
	 * @param rangeFinal the rangeFinal to set
	 */
	public void setRangeFinal(String rangeFinal) {
		this.rangeFinal = rangeFinal;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
