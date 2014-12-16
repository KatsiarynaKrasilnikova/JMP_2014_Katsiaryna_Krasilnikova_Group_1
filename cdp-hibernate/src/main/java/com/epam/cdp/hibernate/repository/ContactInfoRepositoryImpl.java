package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.ContactInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Ilya_Kukushkin on 12/15/2014
 */
@Repository
public class ContactInfoRepositoryImpl extends GenericRepositoryImpl<ContactInfo, Long> implements IContactInfoRepository {

    public ContactInfoRepositoryImpl() {
        super(ContactInfo.class);
    }
}
