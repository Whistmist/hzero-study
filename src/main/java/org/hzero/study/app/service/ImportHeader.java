package org.hzero.study.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.repository.HeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * <p>
 * -- Header  导入
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-10-16
 */
/*@ImportService(templateCode = "ORA-25178-TEST",sheetIndex = 0)
public class ImportHeader implements IDoImportService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HeaderRepository headerRepository;

    @Override
    public Boolean doImport(String data) {
        Header header;
        try {
            header = objectMapper.readValue(data, Header.class);
        } catch (IOException e) {
            // 失败
            return false;
        }
        int i = headerRepository.insertSelective(header);
        //成功
        return true;
    }
}*/
