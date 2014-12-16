package com.epam.cdp.hibernate.service;

import com.epam.cdp.hibernate.model.ContactInfo;
import com.epam.cdp.hibernate.repository.IContactInfoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
@Service
public class ContactServiceImpl extends GenericServiceImpl<ContactInfo, Long, IContactInfoRepository> implements IContactInfoService {
}
