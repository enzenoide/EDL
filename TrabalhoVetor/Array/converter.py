import pdfkit
import os
from pygments import highlight
from pygments.lexers import JavaLexer
from pygments.formatters import HtmlFormatter

lista_arquivos = []
nome_arquivo = input("Digite o nome que você deseja colocar no arquivo: ")
estilo_customizado = """
<style>
    pre { 
        font-family: 'Liberation Mono', 'Courier New', monospace !important; 
        font-size: 14pt !important; 
        line-height: 1.4 !important; 
    }
    .linenos { 
        font-size: 12pt !important; 
        padding-right: 10px;
    }
</style>
"""
print("Digite o nome dos arquivos ou sair para finalizar")

while(True):
    
    arquivos = input("Arquivo: ").strip()

    if arquivos.lower() == 'sair':
        break
    if os.path.exists(arquivos):
        lista_arquivos.append(arquivos)
    else:
        print(f"O arquivo: {arquivos} que voce digitou não existe")
print(f"\nLista final para o PDF: {lista_arquivos}")

codigo = ""

for arq in lista_arquivos:
    with open(arq, 'r', encoding='utf-8') as f:
        codigo += f"\n// --- ARQUIVO: {arq} ---\n"
        codigo += f.read() + "\n"
options = {
    'page-size': 'A4',
    'margin-top': '15mm',
    'margin-right': '15mm',
    'margin-bottom': '15mm',
    'margin-left': '15mm',
    'encoding': "UTF-8",
    'zoom': '1.5',  
    'no-outline': None
}
formatter = HtmlFormatter(full = True,style = 'monokai',linenos = True)
html_base = highlight(codigo,JavaLexer(),formatter)
html_final = html_base.replace('</head>', f'{estilo_customizado}</head>')
try:
    pdfkit.from_string(html_final, f'{nome_arquivo}.pdf',options=options)
    print("PDF gerado com sucesso!")
except Exception as e:
    print(f"Erro ao gerar PDF: {e}")

