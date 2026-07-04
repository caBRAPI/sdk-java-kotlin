# Segurança

A segurança deste SDK é tratada com prioridade. Se você identificar uma vulnerabilidade, agradecemos pelo reporte responsável para que possamos investigar e corrigir o problema rapidamente.

## Reportando uma vulnerabilidade

Envie os detalhes por um dos canais abaixo:

* Envie um e-mail para o setor responsável `suporte@cabrapi.com.br` 

* Ou envie um e-mail diretamente para o desenvolvedor responsável `sebastianjnuwu@gmail.com`.

## Informações importantes no reporte

Sempre que possível, inclua:

* Versão afetada do SDK
  Exemplo: `1.0.0`

* Ambiente utilizado
  Exemplo: Java 17, Java 21, Minecraft Spigot/Paper, Maven, Gradle

* Passos detalhados para reproduzir o problema

* Comportamento esperado e comportamento observado

* Logs, stack traces e provas de conceito (PoC)

* Impacto potencial da vulnerabilidade

## Processo de resposta

Nós comprometemos a seguir um processo de divulgação responsável:

1. Confirmamos o recebimento do reporte em até **72 horas**
2. Investigamos o problema e avaliamos o impacto
3. Quando necessário, desenvolvemos uma correção e publicamos uma nova versão
4. Emitimos uma nota de segurança e CVE (quando aplicável)
5. O autor do reporte será informado antes da divulgação pública

## Política de divulgação responsável

Para proteger os usuários do projeto:

* Não divulgue detalhes técnicos da vulnerabilidade publicamente antes da correção oficial
* Evite publicar exploits, PoCs ou métodos de reprodução em Issues públicas
* Aguarde a liberação do patch e da nota de segurança

## Recomendações de segurança

Para reduzir riscos em produção:

* Utilize sempre a versão mais recente do SDK
* Mantenha seus runtimes atualizados
  Recomendado: `Java >= 8`
* Nunca exponha chaves privadas no cliente
* Armazene segredos usando variáveis de ambiente seguras
* Implemente validação e autenticação adequadas no servidor

Agradecemos sua colaboração em manter o ecossistema mais seguro para todos.
