def replace_question_marks(input_file, output_file):
    counter = 1
    with open("C:\Users\jpcas\Documents\GitHub\PrograJp\Java\Pokemon\pokemon_completado.txt", 'r', encoding='utf-8') as file:
        content = file.read()
    
    modified_content = []
    for char in content:
        if char == '¿':
            modified_content.append(str(counter))
            counter += 1
        else:
            modified_content.append(char)
    
    modified_content = ''.join(modified_content)
    
    with open(output_file, 'w', encoding='unicodeescape') as file:
        file.write(modified_content)

# Example usage:
input_filename = 'C:\Users\jpcas\Documents\GitHub\PrograJp\Java\Pokemon\pokemon_completado.txt'  # Replace with your input file path
output_filename = 'C:\Users\jpcas\Documents\GitHub\PrograJp\Java\experimento.txt'  # Replace with your desired output file path
replace_question_marks(input_filename, output_filename)
print(f"Replaced all ¿ characters with incrementing numbers. Output saved to {output_filename}")