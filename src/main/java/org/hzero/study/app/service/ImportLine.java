package org.hzero.study.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.study.domain.entity.Line;
import org.hzero.study.domain.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * <p>
 * -- Header  导入
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-10-16
 */
/*@ImportService(templateCode = "ORA-25178-TEST",sheetIndex = 1)
public class ImportLine implements IDoImportService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LineRepository lineRepository;

    @Override
    public Boolean doImport(String data) {
        Line line;
        try {
            line = objectMapper.readValue(data, Line.class);
        } catch (IOException e) {
            // 失败
            return false;
        }
        int i = lineRepository.insertSelective(line);
        // 成功
        return true;
    }
}*/
