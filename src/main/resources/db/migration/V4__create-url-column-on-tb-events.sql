ALTER TABLE tb_events
    ADD COLUMN url VARCHAR(512);

UPDATE tb_events
SET url='Discord He4rt'
WHERE id = 1;