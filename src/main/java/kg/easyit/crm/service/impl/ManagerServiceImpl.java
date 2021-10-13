package kg.easyit.crm.service.impl;

import kg.easyit.crm.dto.ManagerDTO;
import kg.easyit.crm.mapper.ManagerMapper;
import kg.easyit.crm.repository.ManagerRepository;
import kg.easyit.crm.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    final ManagerRepository managerRepository;

    @Override
    public ManagerDTO getOneById(Long id) {
        return ManagerMapper
                .INSTANCE
                .toDto(managerRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }
}
