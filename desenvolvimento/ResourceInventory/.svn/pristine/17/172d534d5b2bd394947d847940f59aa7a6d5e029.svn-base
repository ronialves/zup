package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tlf.oss.resourceinventory.granite.core.to.ResultTo;
@Table(name="card_attr_settings")
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryAcessInformationResourceDSLAM",query=
			"SELECT DISTINCT NVL((SELECT cas.attr_value voiceProtocol "+
					"                   FROM val_attr_name van, card_attr_settings cas "+
					"                  WHERE van.group_name = 'CARTAO_PROTOCOLOS' "+
					"                    AND van.attr_name = 'PROTOCOLO_VOZ' "+
					"                    AND van.val_attr_inst_id = cas.val_attr_inst_id "+
					"                    AND cas.card_inst_id = ci.card_inst_id),'TDM') voiceProtocol, "+
					"                ei.type "+
					"  FROM equip_inst ei, card_inst ci, site_inst si "+
					" WHERE ei.equip_inst_id = ci.equip_inst_id "+
					"   AND ei.type = 'DSLAM' "+
					"   AND ei.status = 'ATIVO' "+
					"   AND ei.site_inst_id = si.site_inst_id "+
					"   AND EXISTS (SELECT 1 "+
					"          FROM site_attr_settings sas, val_attr_name van "+
					"         WHERE sas.val_attr_inst_id = van.val_attr_inst_id "+
					"           AND van.group_name = 'LOCALIDADE' "+
					"           AND van.attr_name = 'CNL' "+
					"           AND sas.site_inst_id = si.site_inst_id "+
					"           AND sas.attr_value = ?) "+
					"   AND EXISTS (SELECT 1 "+
					"          FROM site_attr_settings sas, val_attr_name van "+
					"         WHERE sas.val_attr_inst_id = van.val_attr_inst_id "+
					"           AND van.group_name = 'LOCALIDADE' "+
					"           AND van.attr_name = 'SIGLA_AT' "+
					"           AND sas.site_inst_id = si.site_inst_id "+
					"           AND sas.attr_value = ?)",resultClass = RetrieveAccessResourceInformationDslamEntity.class)})

public class RetrieveAccessResourceInformationDslamEntity  extends EntityCommon<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="voiceProtocol")
	private String voiceProtocol;

	@Transient
	private String accessTecnology;

	@Column(name="type")
	private String typeOfResource;

	@Transient
	private ResultTo result ;

	public ResultTo getResult() {
		if(null==result){
			result= new ResultTo();
		}
		return result;
	}
	public void setResult(ResultTo result) {
		this.result = result;
	}

	public String getAccessTecnology() {
		return accessTecnology;
	}

	public void setAccessTecnology(String accessTecnology) {
		this.accessTecnology = accessTecnology;
	}

	public String getTypeOfResource() {
		return typeOfResource;
	}

	public String getVoiceProtocol() {
		return voiceProtocol;
	}

	public void setVoiceProtocol(String voiceProtocol) {
		this.voiceProtocol = voiceProtocol;
	}

	public void setTypeOfResource(String typeOfResource) {
		this.typeOfResource = typeOfResource;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}

}
