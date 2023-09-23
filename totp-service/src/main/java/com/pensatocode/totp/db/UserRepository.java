package com.pensatocode.totp.db;

import com.pensatocode.totp.model.User;
import com.warrenstrange.googleauth.ICredentialRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository implements ICredentialRepository {
    private List<User> users;

    public void loadAllUser(List<User> users) {
        this.users = users;
    }

    public List<User> findAll(int size) {
        return users.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(brand -> brand.getId().equals(id))
                .findFirst();
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(brand -> brand.getCredentials().getUsername().equals(username))
                .findFirst();
    }

    @Override
    public String getSecretKey(String username) {
        return findByUsername(username)
                .map(user -> user.getCredentials().getSecretKey().getKey())
                .orElse(null);
    }

    @Override
    public void saveUserCredentials(String userName,
                                    String secretKey,
                                    int validationCode,
                                    List<Integer> scratchCodes) {

    }
}
