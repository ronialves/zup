package com.tlf.oss.resourceinventory.tbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Table(name="NETWORK_LOCATION")
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="QueryNetworkLocation",query=
	"SELECT DISTINCT Q1.CLLI_CODE FROM " +
    "   (SELECT DISTINCT (B.CLLI_CODE) AS CLLI_CODE" +
	"       FROM ASAP.SERVICE_REQUEST_CIRCUIT S," +
	"           ASAP.SERV_REQ                SR," +
	"           ASAP.CIRCUIT                 C," +
	"           ASAP.NETWORK_LOCATION        B" +
	"       WHERE C.CIRCUIT_DESIGN_ID = S.CIRCUIT_DESIGN_ID" +
	"           AND C.TYPE <> 'S'" +
	"           AND B.LOCATION_ID = C.LOCATION_ID" +
	"           AND B.LOCATION_TYPE = 'End Office - Electronic Digital'" +
	"           AND SR.PON = ?" +
	"           AND SR.DOCUMENT_NUMBER = S.DOCUMENT_NUMBER" +
	"           AND S.DOCUMENT_NUMBER = ?" +
	"           UNION ALL" +
	"               SELECT DISTINCT (B.CLLI_CODE) AS CLLI_CODE" +
	"                   FROM ASAP.SERVICE_REQUEST_CIRCUIT S," +
	"                       ASAP.SERV_REQ                SR," +
	"                       ASAP.CIRCUIT                 C," +
	"                       ASAP.NETWORK_LOCATION        B" +
	"                   WHERE C.CIRCUIT_DESIGN_ID = S.CIRCUIT_DESIGN_ID" +
	"                   AND C.TYPE <> 'S'" +
	"                   AND B.LOCATION_ID = C.LOCATION_ID_2" +
	"                   AND B.LOCATION_TYPE = 'End Office - Electronic Digital'" +
	"                   AND SR.PON = ?" +
	"                   AND SR.DOCUMENT_NUMBER = S.DOCUMENT_NUMBER" +
	"                   AND S.DOCUMENT_NUMBER = ?" +
    "   ) Q1", resultClass = RetrieveNetworkLocationEntity.class),
	@NamedNativeQuery(name="QueryNetworkLocationByPilot",query=
	"SELECT DISTINCT C.CLLI_CODE" +
    "       FROM ASAP.ASSIGNED_TEL_NUM A," +
    "           ASAP.NPA_NXX_LOCATION B," +
    "           ASAP.NETWORK_LOCATION C" +
    "       WHERE A.DOCUMENT_NUMBER = ?" +
    "           AND A.IDENTITY_CD = 'MPTN'" +
    "           AND B.NPA = A.TEL_NBR_NPA" +
    "           AND B.NXX = A.TEL_NBR_NXX" +
    "           AND B.LINE_RANGE_LOWER = A.TEL_NBR_LINE_RANGE" +
    "           AND C.LOCATION_TYPE = 'End Office - Electronic Digital'" +
    "           AND C.LOCATION_ID = B.LOCATION_ID", resultClass = RetrieveNetworkLocationEntity.class),
    @NamedNativeQuery(name="QueryNetworkLocationByPilotOrderNumber",query=
    "SELECT DISTINCT C.CLLI_CODE" +
    "      FROM ASAP.ASSIGNED_TEL_NUM A," +
    "           ASAP.NPA_NXX_LOCATION B," +
    "           ASAP.NETWORK_LOCATION C" +
    "       WHERE A.DOCUMENT_NUMBER = ?" +
    "           AND B.NPA = A.TEL_NBR_NPA" +
    "           AND B.NXX = A.TEL_NBR_NXX" +
    "           AND B.LINE_RANGE_LOWER = A.TEL_NBR_LINE_RANGE" +
    "           AND C.LOCATION_TYPE = 'End Office - Electronic Digital'" +
    "           AND C.LOCATION_ID = B.LOCATION_ID", resultClass = RetrieveNetworkLocationEntity.class)
})
public class RetrieveNetworkLocationEntity extends EntityCommon<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLLI_CODE")
	private String CLLICode;
	
	
	
	/**
	 * @return the cLLICode
	 */
	public String getCLLICode() {
		return CLLICode;
	}

	/**
	 * @param cLLICode the cLLICode to set
	 */
	public void setCLLICode(String cLLICode) {
		CLLICode = cLLICode;
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
