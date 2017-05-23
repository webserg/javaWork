import logging

logging.basicConfig(filename='example.log', filemode='w', level=logging.DEBUG)
try:
    1 / 0
except Exception as e:
    logging.exception("message")
    raise e
print("working...")
