
package com.tlf.oss.resourceinventory.generated.osp.reportresourceprovisioning.provisiongtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PairStatusType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="PairStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DS"/&gt;
 *     &lt;enumeration value="RS"/&gt;
 *     &lt;enumeration value="OC"/&gt;
 *     &lt;enumeration value="DL"/&gt;
 *     &lt;enumeration value="DF"/&gt;
 *     &lt;enumeration value="RT"/&gt;
 *     &lt;enumeration value="RA"/&gt;
 *     &lt;enumeration value="CR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PairStatusType")
@XmlEnum
public enum PairStatusType {

    DS,
    RS,
    OC,
    DL,
    DF,
    RT,
    RA,
    CR;

    public String value() {
        return name();
    }

    public static PairStatusType fromValue(String v) {
        return valueOf(v);
    }

}
