package gt.com.tigo.accruedautomation.service.accrued;

import gt.com.tigo.accruedautomation.dao.accrued.VPurchaseOrderDrcRepository;
import gt.com.tigo.accruedautomation.dao.accrued.VPurchaseOrderRepository;
import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.model.accrued.VPurchaseOrderDrcEntity;
import gt.com.tigo.accruedautomation.model.accrued.VPurchaseOrderEntity;
import gt.com.tigo.accruedautomation.service.ICatalog;
import gt.com.tigo.accruedautomation.util.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VPurchaseOrderService implements ICatalog<VPurchaseOrderEntity> {
    private static final Logger logger = LoggerFactory.getLogger(VPurchaseOrderService.class);

    @Autowired
    private VPurchaseOrderRepository vPurchaseOrderRepository;

    @Autowired
    private VPurchaseOrderDrcRepository vPurchaseOrderDrcRepository;

    @Override
    public List<VPurchaseOrderEntity> findAll() throws ResourcesNotFoundException {
        logger.debug(String.format("@%s::findAll()", this.getClass().getName()));

        try {
            return this.vPurchaseOrderRepository.findAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }

    public List<VPurchaseOrderDrcEntity> findDrcAll() throws ResourcesNotFoundException {
        logger.debug(String.format("@%s::findDrcAll()", this.getClass().getName()));

        try {
            return this.vPurchaseOrderDrcRepository.findAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());

            throw new ResourcesNotFoundException();
        }
    }

    @Override
    public PaginatedDataDto<VPurchaseOrderEntity> findAllByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException {
        return null;
    }

    @Override
    public VPurchaseOrderEntity findById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public VPurchaseOrderEntity create(VPurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException {
        return null;
    }

    @Override
    public VPurchaseOrderEntity update(VPurchaseOrderEntity entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException {
        return null;
    }

    @Override
    public VPurchaseOrderEntity delete(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException {
        return null;
    }
}
