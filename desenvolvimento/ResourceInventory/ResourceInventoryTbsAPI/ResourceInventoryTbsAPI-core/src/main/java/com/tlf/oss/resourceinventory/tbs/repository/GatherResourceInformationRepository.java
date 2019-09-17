package com.tlf.oss.resourceinventory.tbs.repository;

import com.tlf.oss.common.exception.OSSBusinessException;
import com.tlf.oss.common.log.OSSLogger;
import com.tlf.oss.resourceinventory.schemas.Cabinet;
import com.tlf.oss.resourceinventory.schemas.PortAdapterCard;
import com.tlf.oss.resourceinventory.schemas.Splitter;
import com.tlf.oss.resourceinventory.tbs.entity.GatherResourceEntity;
import com.tlf.oss.resourceinventory.tbs.repository.factory.GenericRepository;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;

public class GatherResourceInformationRepository extends GenericRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject private OSSLogger ossLogger;

    /**
     * Realiza chamada da procedure ASAP.TLF_SP_ANALISA_FUSION
     *
     * @param portAdapterCard
     * @return GatherResourceEntity
     * @throws OSSBusinessException
     */
    public GatherResourceEntity gatherResourceInformationByEquipment(PortAdapterCard portAdapterCard) throws OSSBusinessException {
        GatherResourceEntity entity = new GatherResourceEntity();
        try {
            TypedQuery<GatherResourceEntity> query;
            query = getFactory().createNamedQuery("gatherResource", GatherResourceEntity.class);
            query.setParameter("P_EQUIPMENT_ID", portAdapterCard.getId());
            query.setParameter("P_ARMARIO", null);
            query.setParameter("P_SPLITTER_1N", null);
            logIn(query, "gatherResource");
            entity = query.getSingleResult();
            logOut(entity);
            getFactory().detach(entity);

        } catch (Exception e) {
            entity.setCodigoRetorno(1);
            entity.setMensagemRetorno(e.getMessage());
        }

        return entity;
    }

    /**
     * Realiza chamada da procedure ASAP.TLF_SP_ANALISA_FUSION
     *
     * @param cabinet
     * @param splitter
     * @return GatherResourceEntity
     * @throws OSSBusinessException
     */
    public GatherResourceEntity gatherResourceInformationByCabinetAndSplitter(Cabinet cabinet, Splitter splitter) throws OSSBusinessException {
        GatherResourceEntity entity = new GatherResourceEntity();
        try {
            TypedQuery<GatherResourceEntity> query;
            query = getFactory().createNamedQuery("gatherResource", GatherResourceEntity.class);
            query.setParameter("P_EQUIPMENT_ID", null);
            query.setParameter("P_ARMARIO", cabinet.getName());
            query.setParameter("P_SPLITTER_1N", splitter.getId());
            logIn(query, "gatherResource");
            entity = query.getSingleResult();
            logOut(entity);
            getFactory().detach(entity);

        } catch (Exception e) {
            entity.setCodigoRetorno(1);
            entity.setMensagemRetorno(e.getMessage());
        }

        return entity;
    }

    /**
     * Gera log com a entrada da query
     *
     * @param query
     * @param queryName
     */
    private void logIn(Query query, String queryName) {
        String log = getlogIn(queryName, query);
        this.ossLogger.log(OSSLogger.INFO, log);
    }

    /**
     * Gera log com o resultado da query executada
     *
     * @param result
     */
    private void logOut(GatherResourceEntity result) {
        this.ossLogger.log(OSSLogger.INFO, result.toString());
    }
}
