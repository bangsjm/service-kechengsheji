package com.youngc.pipeline.service.system;

import com.github.pagehelper.Page;
import com.youngc.pipeline.model.UnitModel;

import java.util.List;

public interface UnitService {

    Page getList(String keyword, int pageNum, int pageSize);

    UnitModel getUnitDetails(Long unitId);

    UnitModel updateUnitDetails(UnitModel unitModel);

    UnitModel addUnit(UnitModel unitModel);

    boolean deleteUnitList(String unitIds);

    List<UnitModel> getUnitByCode(String code);
}
