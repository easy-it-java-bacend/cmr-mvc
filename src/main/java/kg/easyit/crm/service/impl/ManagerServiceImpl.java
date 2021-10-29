package kg.easyit.crm.service.impl;

import kg.easyit.crm.model.dto.ManagerDto;
import kg.easyit.crm.model.respoonse.MessageResponse;
import kg.easyit.crm.repository.ManagerRepository;
import kg.easyit.crm.service.ManagerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManagerServiceImpl implements ManagerService {

    final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return managerRepository.findByUsernameAndIsDeletedFalse(s)
                .orElseThrow(() -> new UsernameNotFoundException("For username='" + s + "'"));
    }

    @Override
    public MessageResponse save(ManagerDto managerDTO) {
        return null;
    }

    @Override
    public ManagerDto findOne(Long id) {
        return null;
    }

    @Override
    public MessageResponse updateFirstName(String firstName) {
        return null;
    }

    @Override
    public MessageResponse updateLastName(String lastName) {
        return null;
    }

    @Override
    public MessageResponse updatePhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public MessageResponse deleteOne(Long id) {
        return null;
    }
}
