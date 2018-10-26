export enum StatusType {
  SCHEDULED = 'Envio da pendência agendado',
  INTEGRATING = 'Processando a pendência',
  SENT_TO_PROVIDER = 'Pendência enviada ao prestador SST',
  ON_PROVIDER = 'Pendência recebida com sucesso pelo prestador SST',
  INTEGRATION_ERROR = 'Erro no envio ou no recebimento da pendência pelo prestador SST',
  CANCELED = 'Pendência cancelada',
  IN_ANALYSIS = 'Pendência em análise',
  IRRELEVANT = 'Pendência irrelevante para o prestador SST',
  ANALYSIS_ERROR = 'Erro durante a análise'
}
