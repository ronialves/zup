package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.enums.StatusMsanPotsType;
import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;

@Table(name = "conexoes_pots_msan")
@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = UpdateMsanPotsEntity.QUERY_UPDATE_MSAN_POTS, query = "UPDATE conexoes_pots_msan cpm"
				+ " set cpm.status_pots=cpm.last_status_pots,"
				+ " cpm.last_status_pots=null											"
				+ "	WHERE cpm.id_conexoes_pots_msan = ?"),
		@NamedNativeQuery(name = UpdateMsanPotsEntity.QUERY_UPDATE_STATUS_MSAN_POTS, query = "UPDATE conexoes_pots_msan cpm"
				+ " set cpm.last_status_pots=cpm.status_pots,"
				+ " cpm.status_pots = ?"
				+ " WHERE cpm.id_conexoes_pots_msan = ?")})
public class UpdateMsanPotsEntity extends EntityCommon<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String QUERY_UPDATE_MSAN_POTS = "QueryUpdateMsanPots";
	
	public static final String QUERY_UPDATE_STATUS_MSAN_POTS = "QueryUpdateStatusMsanPots";

	public static final String ID_CONEXOES_POTS_MAN = "id_conexoes_pots_msan";

	@Id
	@Basic
	@Column(name = "id_conexoes_pots_msan")
	private Long idConexoesPotsMsan;

	@Basic
	@Column(name = "status_pots")
	private String statusPots;

	@Basic
	@Column(name = "last_status_pots")
	private String lastStatusPots;

	@Transient
	private ResultTo result;

	public UpdateMsanPotsEntity() {
	}

	public UpdateMsanPotsEntity(Long idConexoesPotsMsan, StatusMsanPotsType statusMsanPots) {
		this.idConexoesPotsMsan = idConexoesPotsMsan;
		this.statusPots = statusMsanPots.getValue();
	}

	public String getStatusPots() {
		return statusPots;
	}

	public void setStatusPots(String statusPots) {
		this.statusPots = statusPots;
	}

	public String getLastStatusPots() {
		return lastStatusPots;
	}

	public void setLastStatusPots(String lastStatusPots) {
		this.lastStatusPots = lastStatusPots;
	}

	public ResultTo getResult() {
		return result;
	}

	public void setResult(ResultTo result) {
		this.result = result;
	}

	@Override
	public Long getId() {
		return idConexoesPotsMsan;
	}

	@Override
	public void setId(Long id) {
		this.idConexoesPotsMsan = id;		
	}

}
