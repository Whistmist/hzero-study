package org.hzero.study.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hzero.boot.imported.app.service.IDoImportService;
import org.hzero.boot.imported.infra.validator.annotation.ImportService;
import org.hzero.study.api.controller.dto.Header2LineDto;
import org.hzero.study.domain.entity.Header;
import org.hzero.study.domain.entity.Line;
import org.hzero.study.domain.repository.HeaderRepository;
import org.hzero.study.domain.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * <p>
 * -- ImportHeaderAndLine
 * </p>
 *
 * @Author: heng.huang@hand-china.com 2019-10-16
 */
@ImportService(templateCode = "ORA-25178-TEST",sheetIndex = 0)
public class ImportHeaderAndLine implements IDoImportService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HeaderRepository headerRepository;
    @Autowired
    private LineRepository lineRepository;

    @Override
    public Boolean doImport(String data) {
        Line line = new Line();
        Header header = new Header();
        Header2LineDto header2LineDto;
        try {
            header2LineDto = objectMapper.readValue(data, Header2LineDto.class);
        } catch (IOException e) {
            // 失败
            return false;
        }
        header.setPrice(header2LineDto.getPrice());
        header.setName(header2LineDto.getName());

        line.setUnitPrice(header2LineDto.getUnitPrice());
        line.setHeaderId(header2LineDto.getHeaderId());
        line.setLineName(header2LineDto.getLineName());
        headerRepository.insertSelective(header);
        lineRepository.insertSelective(line);
        // 成功
        return true;
    }
}
