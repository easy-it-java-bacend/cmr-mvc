package kg.easyit.crm.service;

import kg.easyit.crm.dto.ManagerDTO;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {
    ManagerDTO getOneById(Long id);
}
