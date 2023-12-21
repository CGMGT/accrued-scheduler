package gt.com.tigo.accruedautomation.dao.accrued;

import gt.com.tigo.accruedautomation.model.accrued.VPurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VPurchaseOrderRepository extends JpaRepository<VPurchaseOrderEntity, Long>, JpaSpecificationExecutor<VPurchaseOrderEntity> {
}
