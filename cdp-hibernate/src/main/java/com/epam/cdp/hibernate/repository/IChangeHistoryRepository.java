package com.epam.cdp.hibernate.repository;

import com.epam.cdp.hibernate.model.ChangeHistory;

/**
 * Created by Ilya_Kukushkin on 12/22/2014
 */
public interface IChangeHistoryRepository {

    public void save(ChangeHistory changeHistory);
}
