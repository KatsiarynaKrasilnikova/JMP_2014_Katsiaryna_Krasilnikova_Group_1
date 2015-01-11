package com.epam.cdp.spring.service;

import com.epam.cdp.hibernate.model.ContactInfo;
import com.epam.cdp.hibernate.repository.IContactInfoRepository;

/**
 * Created by Ilya_Kukushkin on 12/16/2014
 */
public interface IContactInfoService extends IGenericService<ContactInfo, Long, IContactInfoRepository> {
}
