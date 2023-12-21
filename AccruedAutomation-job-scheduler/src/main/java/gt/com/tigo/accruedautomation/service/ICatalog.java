package gt.com.tigo.accruedautomation.service;

import gt.com.tigo.accruedautomation.dto.DataTableRequestDto;
import gt.com.tigo.accruedautomation.dto.PaginatedDataDto;
import gt.com.tigo.accruedautomation.util.exception.*;

import java.util.List;

public interface ICatalog<T> {

    List<T> findAll() throws ResourcesNotFoundException;

    PaginatedDataDto<T> findAllByPage(DataTableRequestDto dataTableRequestDto) throws ResourcesNotFoundException;

    T findById(Long id) throws ResourceNotFoundException;

    T create(T entity, Long requesterId) throws RequesterNotFoundException, ResourceCreateException;

    T update(T entity, Long requesterId) throws RequesterNotFoundException, ResourceUpdateException;

    T delete(Long entityId, Long requesterId) throws RequesterNotFoundException, ResourceNotFoundException, ResourceUpdateException;

}
