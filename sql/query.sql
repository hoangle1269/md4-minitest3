create
    definer = root@localhost procedure deletemanufacturerbyid(IN manufacturerId bigint)
begin
    update computer set manufacturer_id = null where manufacturer_id = manufacturerId;
    delete from manufacturer where manufacturer.manufacturerId = manufacturerId;
end;

create
    definer = root@localhost procedure countNumbersOfManufacturer()
begin
    select manufacturer.manufacturerName, count(computerId) as number
    from manufacturer
             left join minitest2_computer.computer c on manufacturer.manufacturerId = c.manufacturer_id
    group by manufacturer.manufacturerName;
end;

