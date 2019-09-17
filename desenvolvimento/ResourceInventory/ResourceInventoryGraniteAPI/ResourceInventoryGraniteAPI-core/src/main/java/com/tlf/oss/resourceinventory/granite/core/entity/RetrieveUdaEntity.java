package com.tlf.oss.resourceinventory.granite.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Table(name="val_attr_name")
@Entity
@NamedNativeQuery(
		name="QueryUDAConfig",
		query=
			"SELECT 'uda_vpn' uda_nome, v.val_attr_inst_id uda_id "+
			"FROM val_attr_name v "+
			"WHERE v.group_name = 'EQUIPAMENTO_GERAL' "+
			"AND v.attr_name = 'SERVICO_VPN' "+
			"union "+
			"SELECT 'uda_ip' uda_nome, v.val_attr_inst_id uda_id "+
			"FROM val_attr_name v "+
			"WHERE v.group_name = 'ATIVACAO_UPLOAD_LOG' "+
			"AND v.attr_name = 'TIPO_ENDERECAMENTO' "+
			"union "+
			"SELECT 'uda_tipo_porta' uda_nome, v.val_attr_inst_id uda_id "+
			"FROM val_attr_name v "+
			"WHERE v.group_name = 'ATIVACAO_UPLOAD_FIS' "+
			"AND v.attr_name = 'TIPO' "+
			"union "+
			"SELECT 'uda_tipo_rede' uda_nome, v.val_attr_inst_id uda_id "+
			"   FROM val_attr_name v "+
			"  WHERE v.group_name = 'EQUIPAMENTO_GERAL' "+
			"    AND v.attr_name = 'TIPO_REDE' "+
			"union "+
			"SELECT 'uda_cnl' uda_nome, v.val_attr_inst_id uda_id "+
			"  FROM val_attr_name v "+
			" WHERE v.group_name = 'LOCALIDADE' "+
			"   AND v.attr_name = 'CNL' "+
			"union "+
			"SELECT 'uda_protocolo' uda_nome, v.val_attr_inst_id uda_id "+
			"  FROM val_attr_name v "+
			" WHERE v.group_name = 'CARTAO_PROTOCOLOS' "+
			"   AND v.attr_name = 'PROTOCOLO_VOZ' "+ 
			"union "+
			"SELECT 'uda_sigla_at' uda_nome, v.val_attr_inst_id uda_id "+
			"  FROM val_attr_name v "+
			" WHERE v.group_name = 'LOCALIDADE' "+
			"   AND v.attr_name = 'SIGLA_AT' "+
			"union "+
			"SELECT 'uda_nome_engenharia' uda_nome, v.val_attr_inst_id uda_id "+
			" FROM val_attr_name v "+
			" WHERE v.group_name = 'EQUIPAMENTO_ENGENHARIA' "+ 
			" AND v.attr_name = 'NOME_EQUIPAMENTO'", 
		resultClass = RetrieveUdaEntity.class)
public class RetrieveUdaEntity extends EntityCommon<Long> implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "uda_id")
	private Integer uda_id;

	@Column(name = "uda_nome")
	private String uda_nome;

	public String getUda_nome() {
		return uda_nome;
	}
	public void setUda_nome(String uda_nome) {
		this.uda_nome = uda_nome;
	}

	public Integer getUda_id() {
		return uda_id;
	}
	public void setUda_id(Integer uda_id) {
		this.uda_id = uda_id;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long arg0) {
		// TODO Auto-generated method stub

	}

}
