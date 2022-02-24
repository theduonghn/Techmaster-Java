SELECT r.name , rd.id_document , d.name , rd.borrow_date, bs.last_date_to_return , rd.borrow_quantity , rd.return_quantity 
FROM reader r 
INNER JOIN reader_document rd ON r.id = rd.id_reader 
INNER JOIN document d ON d.id = rd.id_document 
INNER JOIN borrow_slip bs ON bs.id_reader = r.id
INNER JOIN borrow_slip_document bsd ON bs.id = bsd.id_borrow_slip 
-- WHERE rd.return_quantity < rd.borrow_quantity 
