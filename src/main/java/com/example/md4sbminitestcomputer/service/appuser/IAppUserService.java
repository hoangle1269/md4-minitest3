package com.example.md4sbminitestcomputer.service.appuser;

import com.example.md4sbminitestcomputer.model.AppUser;
import com.example.md4sbminitestcomputer.service.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGenerateService<AppUser>, UserDetailsService {
}
