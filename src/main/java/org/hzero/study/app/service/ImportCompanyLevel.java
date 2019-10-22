package org.hzero.study.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.study.domain.entity.Company25178Level;
import org.hzero.study.domain.repository.Company25178LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 公司级别导入
 *
 * @author heng.huang@hand-china.com 2019-10-15 17:32:35
 */
@ImportService(templateCode = "ORA-25178-COMPANYLEVEL")
public class ImportCompanyLevel implements IDoImportService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private Company25178LevelRepository company25178LevelRepository;

    @Override
    public Boolean doImport(String data) {
        Company25178Level company25178Level;
        try {
            company25178Level = objectMapper.readValue(data, Company25178Level.class);
        } catch (IOException e) {
            // 失败
            return false;
        }
        company25178LevelRepository.insertSelective(company25178Level);
        // 成功
        return true;
    }
}
